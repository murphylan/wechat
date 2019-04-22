interface NavAttributes {
  [propName: string]: any;
}
interface NavWrapper {
  attributes: NavAttributes;
  element: string;
}
interface NavBadge {
  text: string;
  variant: string;
}
interface NavLabel {
  class?: string;
  variant: string;
}

export interface NavData {
  name?: string;
  url?: string;
  icon?: string;
  badge?: NavBadge;
  title?: boolean;
  children?: NavData[];
  variant?: string;
  attributes?: NavAttributes;
  divider?: boolean;
  class?: string;
  label?: NavLabel;
  wrapper?: NavWrapper;
}

export const navItems: NavData[] = [
  {
    name: 'Dashboard',
    url: '/dashboard',
    icon: 'icon-speedometer',
    badge: {
      variant: 'info',
      text: 'NEW'
    }
  },
  {
    title: true,
    name: '数据库'
  },
  {
    name: '数据库列表',
    url: '/db/dblist',
    icon: 'icon-drop'
  },
  {
    name: '添加表',
    url: '/db/dbform',
    icon: 'icon-drop'
  },
  {
    divider: true
  },
  {
    name: '日历',
    url: '/calendar',
    icon: 'icon-drop'
  },
];
